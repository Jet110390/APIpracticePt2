package com.example.apipracticept2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apipracticept2.databinding.PostItemBinding
import com.example.apipracticept2.model.network.models.User

class PostAdapter (
    private val postList: List<User>
): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    class PostViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            with(binding) {
                identityTv.text =
                    "${user.name}\nid: ${user.id} \nusername: ${user.username}"
                addressTv.text =
                    "Address: ${user.address.street},${user.address.suite}\nArea: ${user.address.city}, ${user.address.zipcode}\n Location: latitude - ${user.address.geo.lat} longitude - ${user.address.geo.lng}"
                contactInfoTv.text =
                    "Email ${user.email}\nPhone Number: ${user.phone}\nWebsite: ${user.website}"
                companyTv.text =
                    "Company: ${user.company.name} - ${user.company.bs}\n Service: ${user.company.catchPhrase}"
            }

        }
    }
}
