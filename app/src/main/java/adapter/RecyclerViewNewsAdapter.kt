package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lus.NewsFrag
import com.example.lus.R

class RecyclerViewNewsAdapter(val context: Context, private var list: List<NewsFrag>, val listener: OnItemClickListener):
    RecyclerView.Adapter<RecyclerViewNewsAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val imageView : ImageView
        val textView : TextView
        val textView2 : TextView

        val item: CardView = view.findViewById(R.id.item)

        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.item_title)
            textView2 = itemView.findViewById(R.id.item_details)

            item.setOnClickListener(this)

        }

        fun setData(newsFrag: NewsFrag){
            textView.text = newsFrag.title
            textView2.text = newsFrag.description

            Glide.with(imageView)
                .load(newsFrag.imageUrl)
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
     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_recycler_view,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsFrag = list[position]
        holder.setData(newsFrag)
    }

    override fun getItemCount() = list.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}