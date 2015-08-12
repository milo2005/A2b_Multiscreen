package creatic.movil.multiscreen.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import creatic.movil.multiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    TextView txt;
    int pos;

    public DetailFragment() {}

    public void init(int pos){
        this.pos = pos;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        txt = (TextView) v.findViewById(R.id.txt);
        setColor(pos);
        return v;
    }

    public void setColor(int color){
        String colorName[] = getActivity().getResources()
                .getStringArray(R.array.colors_name);
        int colors[] = getActivity().getResources()
                .getIntArray(R.array.colors);

        txt.setText(colorName[color]);
        txt.setBackgroundColor(colors[color]);
    }




}
