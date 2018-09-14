package jsondroid.android.com.struatebardemo.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import jsondroid.android.com.struatebardemo.R;

public class Fragment3 extends Fragment {
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    private View rootview;
    private View mFfLlRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (rootview == null) {
            rootview = inflater.inflate(R.layout.fragment_fragment3, container, false);
            mFfLlRoot = rootview.findViewById(R.id.status_bar_fix);

            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mFfLlRoot.getLayoutParams();
            lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.height = getStatusbarheight();
            mFfLlRoot.setLayoutParams(lp);
//            mFfLlRoot.setPadding(0,getStatusbarheight(),0,0);
//            mFfLlRoot.invalidate();
        }


        return rootview;

    }

    private int getStatusbarheight() {
        int result = 0;
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getActivity().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

}
