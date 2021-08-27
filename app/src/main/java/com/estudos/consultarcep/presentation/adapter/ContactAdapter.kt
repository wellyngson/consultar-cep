package com.estudos.consultarcep.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.estudos.consultarcep.R
import com.estudos.consultarcep.data.model.Contact
import com.estudos.consultarcep.databinding.ItemContactBinding

class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindViewHolder(getItem(position))
    }

    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemContactBinding = ItemContactBinding.bind(itemView)

        fun bindViewHolder(contact: Contact) {
                binding.tvNumber.text = contact.phone.toString()
                binding.tvName.text = contact.name
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact) = oldItem == newItem
        override fun areContentsTheSame(oldItem: Contact, newItem: Contact) =
            oldItem.id == newItem.id
    }
}
