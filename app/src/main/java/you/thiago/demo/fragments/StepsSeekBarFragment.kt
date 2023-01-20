package you.thiago.demo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import you.thiago.demo.R
import you.thiago.demo.databinding.FragmentStepBinding
import java.util.ArrayList

/**
//                       _ooOoo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                       O\ = /O
//                   ____/`---'\____
//                 .   ' \\| |// `.
//                  / \\||| : |||// \
//                / _||||| -:- |||||- \
//                  | | \\\ - /// | |
//                | \_| ''\---/'' | |
//                 \ .-\__ `-` ___/-. /
//              ______`. .' /--.--\ `. . __
//           ."" '< `.___\_<|>_/___.' >'"".
//          | | : `- \`.;`\ _ /`;.`/ - ` : | |
//            \ \ `-. \_ __\ /__ _/ .-` / /
//    ======`-.____`-.___\_____/___.-`____.-'======
//                       `=---='
//
//    .............................................
//             佛祖保佑             永无BUG
 * =====================================================
 * 作    者：JayGoo
 * 创建日期：2019-06-14
 * 描    述:
 * =====================================================
 */
class StepsSeekBarFragment : Fragment(R.layout.fragment_step) {

	private var binding: FragmentStepBinding? = null

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentStepBinding.bind(view)

		binding?.also {
			setupView(it)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}

	private fun setupView(binding: FragmentStepBinding) {
		with(binding) {
			val stepsDrawables = ArrayList<Int>()

			stepsDrawables.add(R.drawable.step_1)
			stepsDrawables.add(R.drawable.step_2)
			stepsDrawables.add(R.drawable.step_3)
			stepsDrawables.add(R.drawable.step_4)

			sbSteps1.setStepsDrawable(stepsDrawables)
			sbSteps2.setStepsDrawable(stepsDrawables)
		}
	}
}