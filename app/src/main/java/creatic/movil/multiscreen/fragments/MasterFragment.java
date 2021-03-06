package creatic.movil.multiscreen.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import creatic.movil.multiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements AdapterView.OnItemClickListener {

    public interface MasterFragmentI{
        void setColor(int pos);
    }

    ListView list;
    MasterFragmentI masterFragmentI;

    public MasterFragment() {}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        masterFragmentI = (MasterFragmentI) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.f_master, container, false);
        list = (ListView) v.findViewById(R.id.list);
        list.setOnItemClickListener(this);

        return v;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        masterFragmentI.setColor(position);
    }
}
