package you.thiago.demo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import you.thiago.demo.fragments.RangeSeekBarFragment;
import you.thiago.demo.fragments.SingleSeekBarFragment;
import you.thiago.demo.fragments.StepsSeekBarFragment;
import you.thiago.demo.fragments.VerticalSeekBarFragment;

public class MainActivity extends AppCompatActivity {

    private static final String[] types = new String[]{"SINGLE", "RANGE", "STEP", "VERTICAL"};

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        fragments.clear();
        fragments.add(new SingleSeekBarFragment());
        fragments.add(new RangeSeekBarFragment());
        fragments.add(new StepsSeekBarFragment());
        fragments.add(new VerticalSeekBarFragment());

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.layout_tab);

        viewPager.setAdapter(new PagerAdapter(this));

        for (String s: types){
            tabLayout.newTab().setText(s);
        }

        TabLayoutMediator mediator = new TabLayoutMediator(
                tabLayout,
                viewPager,
                (tab, position) -> tab.setText(types[position])
        );

        mediator.attach();
    }

    private class PagerAdapter extends FragmentStateAdapter {

        public PagerAdapter(FragmentActivity activity) {
            super(activity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }
}
