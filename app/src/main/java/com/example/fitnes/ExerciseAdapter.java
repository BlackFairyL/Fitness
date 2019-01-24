package com.example.fitnes;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import APIParse.Exercise;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {

    private List<Exercise> data;
    private ArrayList<Exercise> inTraining;
    private List<Exercise> chosen;
    private ListItemClickListener mOnClickListener;

    public ExerciseAdapter(List<Exercise> data, List<Exercise> inTraining, ListItemClickListener listener) {
        this.data = data;
        this.inTraining = (ArrayList<Exercise>)inTraining;
        chosen = this.inTraining;
        mOnClickListener = listener;
    }

    public void setData(List<Exercise> inTraining){
        this.inTraining = (ArrayList<Exercise>)inTraining;
        chosen = inTraining;
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.item_exercise,
                        parent,
                        false));
    }

    boolean checkExerciseInArray(ArrayList<Exercise> list, Exercise exercise){
        for (Exercise cur : list){
            if (cur.getId() == exercise.getId())
                return true;
        }
        return false;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ViewHolder holder, int position) {
        Exercise exercise = data.get(position);
        holder.name.setText(exercise.getName());
        if (checkExerciseInArray(inTraining, exercise))
            holder.name.setText(holder.name.getText().toString() + " chosen");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            name = view.findViewById(R.id.name);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    mOnClickListener.onListItemClick(clickedPosition);
                }
            });
        }
    }
}
