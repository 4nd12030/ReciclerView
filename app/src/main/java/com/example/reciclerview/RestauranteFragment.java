package com.example.reciclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reciclerview.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {

    MyRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;

    private int mColumnCount = 1;
    //private OnListFragmentIteractionListener mListener;


    public RestauranteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new MyRecyclerViewAdapter(PlaceholderContent.ITEMS));

            //Crear Lista de elementos (Restaurantes)
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Andy", "", 4.8f, "Av 1 Iztapalapa"));
            restauranteList.add(new Restaurante("Hamburguesas Olap", "", 2.8f, "Av 5 Iztapalapa"));
            restauranteList.add(new Restaurante("Antojitos Mexicanos", "", 1.8f, "Av 4 Iztapalapa"));
            // Asociamos el adaptador al ReciclerView
            adapterRestaurantes = new MyRecyclerViewAdapter(restauranteList,mListener);
            recyclerView.setAdapter(adapterRestaurantes);
        }
        return view;
    }
}