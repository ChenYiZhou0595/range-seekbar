package you.thiago.demo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import you.thiago.demo.R
import you.thiago.demo.databinding.FragmentRangeBinding
import you.thiago.widget.OnRangeChangedListener
import you.thiago.widget.RangeSeekBar
import you.thiago.widget.SeekBar

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
class RangeSeekBarFragment : Fragment(R.layout.fragment_range) {

	private var binding: FragmentRangeBinding? = null

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentRangeBinding.bind(view)

		binding?.also {
			setupView(it)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}

	private fun setupView(binding: FragmentRangeBinding) {
		with (binding) {
			sbRange1.setProgress(0f, 100f)

			changeSeekBarThumb(
				sbRange1.leftSeekBar,
				sbRange1.leftSeekBar.progress
			)

			changeSeekBarThumb(
				sbRange1.rightSeekBar,
				sbRange1.rightSeekBar.progress
			)

			sbRange1.setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
					changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
					changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
				}

				override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

				}

				override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

				}

			})

			sbRange2.setProgress(0f, 100f)

			sbRange3.setRange(-100f, 100f)
			sbRange3.setProgress(0f, 80f)
			sbRange3.setIndicatorTextDecimalFormat("0")

			sbRange4.setProgress(20f, 70f)
			sbRange5.setProgress(20f, 60f)
			sbRange6.setProgress(20f, 70f)
			sbRange8.setProgress(20f, 60f)

			sbRange8.leftSeekBar.thumbDrawableId = R.drawable.step_1
			sbRange8.rightSeekBar.thumbDrawableId = R.drawable.step_2
		}
	}

	private fun changeSeekBarThumb(seekbar: SeekBar?, value: Float) {
		if (seekbar == null) {
			return
		}

		if (value < 33){
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		}else if (value < 66){
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		}else{
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}
}