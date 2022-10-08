package com.example.heetprojectfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<Model,myadapter.myviewholder>
{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public myadapter(@NonNull FirebaseRecyclerOptions<Model> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Model model)
    {
            holder.name.setText(model.getN());
            holder.email.setText(model.getE());
            holder.pass.setText(model.getP());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);
        return new myviewholder(view);
    }
    class myviewholder extends RecyclerView.ViewHolder
    {

        TextView name,pass,email;


        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            // img=(CircleImageView) itemView.findViewById(R.id.img1);
            name=itemView.findViewById(R.id.txt1);
            email=itemView.findViewById(R.id.txt2);
            pass=itemView.findViewById(R.id.txt3);

        }
    }

}
