package com.deitel.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deitel.flixster.R.id


class BestSellerBooksRecyclerViewAdapter(
    private val shows: List<NowPlayingMovie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<BestSellerBooksRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_now_playing_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: NowPlayingMovie? = null
        val mTvShow: TextView = mView.findViewById<View>(id.tv_title) as TextView
        val mTvName: TextView = mView.findViewById<Button>(id.button) as Button
        val mTvImage: ImageView = mView.findViewById<View>(id.tv_image) as ImageView

        override fun toString(): String {
            return mTvShow.toString() + " '" + mTvName.text + "'"
        }
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val show = shows[position]

        holder.mItem = show
        holder.mTvShow.text = show.tvShows
        holder.mTvName.text = show.name

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/" + show.tvImageUrl)
            .centerInside()
            .into(holder.mTvImage)

        holder.mView.setOnClickListener {
            holder.mItem?.let { show ->
                mListener?.onItemClick(show)
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return shows.size
    }
}