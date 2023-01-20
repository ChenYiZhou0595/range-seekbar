package you.thiago.demo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import you.thiago.widget.OnRangeChangedListener
import you.thiago.widget.RangeSeekBar
import you.thiago.widget.SeekBar
import you.thiago.widget.Utils
import java.util.ArrayList
import you.thiago.demo.R
import you.thiago.demo.databinding.FragmentVerticalBinding

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
 * 创建日期：2019-06-13
 * 描    述:
 * =====================================================
 */
class VerticalSeekBarFragment : Fragment(R.layout.fragment_vertical) {

	private var binding: FragmentVerticalBinding? = null

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentVerticalBinding.bind(view)

		binding?.also {
			setupView(it)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}

	private fun setupView(binding: FragmentVerticalBinding) {
		with (binding) {
			sbVertical2.setIndicatorTextDecimalFormat("0.0")
			sbVertical2.setProgress(0f, 100f)

			changeSeekBarThumb(sbVertical2.leftSeekBar, sbVertical2.leftSeekBar.progress)
			changeSeekBarThumb(sbVertical2.rightSeekBar, sbVertical2.rightSeekBar.progress)

			sbVertical2.setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(
					rangeSeekBar: RangeSeekBar,
					leftValue: Float,
					rightValue: Float,
					isFromUser: Boolean
				) {
					changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
					changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
				}

				override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}

				override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}
			})

			sbVertical3.setIndicatorTextDecimalFormat("0")
			sbVertical4.setIndicatorTextDecimalFormat("0")
			sbVertical4.setIndicatorTextStringFormat("%s%%")
			sbVertical4.setProgress(30f, 60.6f)

			sbVertical6.setProgress(30f)
			sbVertical7.setProgress(40f, 80f)

			sbVertical8.setIndicatorTextDecimalFormat("0.0")

			val stepsDrawables = ArrayList<Int>()
			stepsDrawables.add(R.drawable.step_1)
			stepsDrawables.add(R.drawable.step_2)
			stepsDrawables.add(R.drawable.step_3)
			stepsDrawables.add(R.drawable.step_1)

			sbVertical9.setStepsDrawable(stepsDrawables)

			changeSeekBarIndicator(sbVertical9.leftSeekBar, sbVertical9.leftSeekBar.progress)
			changeSeekBarIndicator(sbVertical9.rightSeekBar, sbVertical9.rightSeekBar.progress)

			sbVertical9.setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(
					rangeSeekBar: RangeSeekBar,
					leftValue: Float,
					rightValue: Float,
					isFromUser: Boolean
				) {
					changeSeekBarIndicator(rangeSeekBar.leftSeekBar, leftValue)
					changeSeekBarIndicator(rangeSeekBar.rightSeekBar, rightValue)
				}

				override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}

				override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}
			})
		}
	}

	private fun changeSeekBarThumb(seekbar: SeekBar, value: Float){
		if (value < 33) {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorAccent)
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		} else if (value < 66) {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorProgress)
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		} else {
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorRed)
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}

	private fun changeSeekBarIndicator(seekbar: SeekBar, value: Float) {
		seekbar.showIndicator(true)

		if (Utils.compareFloat(value, 0f, 3) == 0 ||
			Utils.compareFloat(value, 100f, 3) == 0
		) {
			seekbar.setIndicatorText("smile")
		} else if (Utils.compareFloat(value, 100 / 3f, 3) == 0) {
			seekbar.setIndicatorText("naughty")
		} else if (Utils.compareFloat(value, 200 / 3f, 3) == 0) {
			seekbar.setIndicatorText("lovely")
		} else {
			seekbar.showIndicator(false)
		}
	}
}