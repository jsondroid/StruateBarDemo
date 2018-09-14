package jsondroid.android.com.demo2.fragments;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import jsondroid.android.com.demo2.R;

/**
 * Created by wenbaohe on 2018/9/14.
 */

public class BaseFragment extends Fragment {

    protected int getStatusbarheight() {
        int result = 0;
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getActivity().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    protected void initTopbar(View rootview) {
        View view = rootview.findViewById(R.id.topstrustbar);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = getStatusbarheight();
        view.setLayoutParams(layoutParams);
    }
}
