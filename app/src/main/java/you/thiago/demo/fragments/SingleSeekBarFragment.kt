package you.thiago.demo.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import you.thiago.demo.R
import you.thiago.widget.OnRangeChangedListener
import you.thiago.widget.RangeSeekBar
import you.thiago.demo.databinding.FragmentSingleBinding

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
class SingleSeekBarFragment : Fragment(R.layout.fragment_single) {

	private var binding: FragmentSingleBinding? = null

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentSingleBinding.bind(view)

		binding?.also {
			setupView(it)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		binding = null
	}

	private fun setupView(binding: FragmentSingleBinding) {
		with(binding) {
			sbSingle1.setProgress(10f)
			sbSingle2.setProgress(20f)
			sbSingle3.setProgress(30f)
			sbSingle4.setProgress(40f)
			sbSingle4.setIndicatorTextDecimalFormat("0.00")
			sbSingle4.setIndicatorTextStringFormat("%s%%")
			sbSingle5.setIndicatorTextDecimalFormat("0")

			sbSingle6.setTypeface(Typeface.SANS_SERIF)
			sbSingle6.setOnRangeChangedListener(object : OnRangeChangedListener {
				override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
					when {
						leftValue < 33.33 -> rangeSeekBar.leftSeekBar.setIndicatorText("赶往店中")
						leftValue < 66.66 -> rangeSeekBar.leftSeekBar.setIndicatorText("制作中")
						else -> rangeSeekBar.leftSeekBar.setIndicatorText("配送中")
					}

					if (rangeSeekBar.rangeSeekBarState[0].isMin){
						rangeSeekBar.leftSeekBar.setIndicatorText("商家接单")
					} else if (rangeSeekBar.rangeSeekBarState[0].isMax){
						rangeSeekBar.leftSeekBar.setIndicatorText("已送达")
					}
				}

				override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}

				override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}
			})
		}
	}
}