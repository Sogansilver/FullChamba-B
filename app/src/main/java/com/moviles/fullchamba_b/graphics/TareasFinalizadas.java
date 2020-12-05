package com.moviles.fullchamba_b.graphics;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.moviles.fullchamba_b.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TareasFinalizadas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TareasFinalizadas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TareasFinalizadas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TareasFinalizadas.
     */
    // TODO: Rename and change types and number of parameters
    public static TareasFinalizadas newInstance(String param1, String param2) {
        TareasFinalizadas fragment = new TareasFinalizadas();
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
        View view = inflater.inflate(R.layout.fragment_tareas_finalizadas, container, false);
        return view;




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PieChart piechart = view.findViewById(R.id.piechart);
        ArrayList slice = new ArrayList<>();
        slice.add(new Entry(40,0));
        slice.add(new Entry(20,1));
        String vec[] = {"En proceso","Finalizada"};
        PieDataSet dataset = new PieDataSet(slice, "Actividades");
        piechart.animateX(1500);
        PieData data = new PieData(vec,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        piechart.setData(data);


    }
}