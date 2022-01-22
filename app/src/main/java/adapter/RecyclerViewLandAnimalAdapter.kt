package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lus.R

class RecyclerViewLandAnimalAdapter(val context: Context, private var list: List<LandAnimal>, val listener: OnItemClickListener):
    RecyclerView.Adapter<RecyclerViewLandAnimalAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val imageView : ImageView
        val textView : TextView
        val textView2 : TextView

        val Animals: CardView = view.findViewById(R.id.Animals)

        init {
            imageView = itemView.findViewById(R.id.animal_imageView)
            textView = itemView.findViewById(R.id.animal_title)
            textView2 = itemView.findViewById(R.id.animal_details)

            Animals.setOnClickListener(this)

        }

        fun setData(LandAnimal:LandAnimal){
            textView.text = LandAnimal.title
            textView2.text = LandAnimal.description

            Glide.with(imageView)
                .load(LandAnimal.imageUrl)
                .into(imageView)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.animals_recycler_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val LandAnimal = list[position]
        holder.setData(LandAnimal)
    }

    override fun getItemCount() = list.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}
