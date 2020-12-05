package com.moviles.fullchamba_b.graphics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.moviles.fullchamba_b.R;
import com.moviles.fullchamba_b.model.Actividad;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HrXTarea#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HrXTarea extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HrXTarea() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HrXTarea.
     */
    // TODO: Rename and change types and number of parameters
    public static HrXTarea newInstance(String param1, String param2) {
        HrXTarea fragment = new HrXTarea();
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
        return inflater.inflate(R.layout.fragment_hr_x_tarea, container, false);
    }

    private String usu;
    private List<Actividad> actividadList;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HorizontalBarChart horizontalBarChart = view.findViewById(R.id.horizontalBarchar);

        ArrayList hbar = new ArrayList<String>();

        hbar.add(new BarEntry((float) 6.4,0));
        hbar.add(new BarEntry((float) 7.6,1));
        hbar.add(new BarEntry((float) 4.2,2));
        hbar.add(new BarEntry((float) 4.9,3));
        hbar.add(new BarEntry((float) 3.7,4));
        hbar.add(new BarEntry((float) 2.9,5));
        hbar.add(new BarEntry((float) 10.8,6));
        hbar.add(new BarEntry((float) 7.4,7));
        hbar.add(new BarEntry((float) 9.9,8));
        hbar.add(new BarEntry((float) 5.9,9));

        String vec1[] = {"Tarea1", "Tarea2", "Tarea3", "Tarea4", "Tarea5","Tarea6", "Tarea7", "Tarea8", "Tarea9", "Tarea10"};
        BarDataSet dataSet = new BarDataSet(hbar, "Horas Tarea");
        horizontalBarChart.animateY(1500);
        BarData data1 = new BarData(vec1,dataSet);
        horizontalBarChart.setData(data1);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
    }


}