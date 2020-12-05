package com.moviles.fullchamba_b.graphics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.moviles.fullchamba_b.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HrsTrabajadsxPersonaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HrsTrabajadsxPersonaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HrsTrabajadsxPersonaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HrsTrabajadsxPersonaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HrsTrabajadsxPersonaFragment newInstance(String param1, String param2) {
        HrsTrabajadsxPersonaFragment fragment = new HrsTrabajadsxPersonaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hrs_trabajadsx_persona, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BarChart barChart = view.findViewById(R.id.barchart);
        ArrayList bar = new ArrayList<String>();
        bar.add(new BarEntry(10,0));
        bar.add(new BarEntry(9,1));
        bar.add(new BarEntry(8,2));
        bar.add(new BarEntry(9,3));
        bar.add(new BarEntry(10,4));

        String vec1[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        BarDataSet dataSet = new BarDataSet(bar, "Horas Trabajadas");
        barChart.animateY(1500);
        BarData data1 = new BarData(vec1,dataSet);
        barChart.setData(data1);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

    }
}