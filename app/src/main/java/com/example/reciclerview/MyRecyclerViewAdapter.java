package com.example.reciclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.reciclerview.databinding.FragmentRestauranteBinding;

import java.util.List;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyRecyclerViewAdapter(List<Restaurante> items,OnListFragmentInteractionListener) {

        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.textViewNombreRestaurante.setText(holder.mItem.getNombre());
        holder.textViewDireccionRestaurante.setText(holder.mItem.getDireccion());
        holder.ratingBarValoracionRestaurante.setRating(holder.mItem.getValoracion());
        //Se reuqiere una libreria para la carga de imagenes
        holder.imageViewPhotoRestaurante.setImageResource(holder.mItem.getUrlPhoto());


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarValoracionRestaurante;
        public Restaurante mItem;

        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());

            textViewNombreRestaurante = itemView.findViewById(R.id.textViewNombre);
            textViewDireccionRestaurante = itemView.findViewById(R.id.textViewDireccion);
            imageViewPhotoRestaurante = itemView.findViewById(R.id.imageViewPhoto);
            ratingBarValoracionRestaurante = itemView.findViewById(R.id.ratingBarValoracion);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Restaurante item);
    }
}