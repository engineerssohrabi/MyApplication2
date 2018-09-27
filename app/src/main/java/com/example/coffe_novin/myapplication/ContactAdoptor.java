package com.example.coffe_novin.myapplication;

import android.content.Context;
import android.icu.text.MessagePattern;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdoptor extends RecyclerView.Adapter<ContactAdoptor.ContactViewHolder> {
private List<Contact> contacts= new ArrayList<>();
private Context context;
public static final int TYPE_ROW=0;
    public static final int TYPE_GRID=1;
    private int type=TYPE_ROW;
public ContactAdoptor(Context context){
    this.context=context;
}
public void addContact (Contact  contact){
    contacts.add(contact);
    notifyItemInserted(contacts.indexOf(contact));
    }
    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view;
      LayoutInflater layoutInflater=LayoutInflater.from(context);
      switch (type){
          case TYPE_ROW:
                    view= layoutInflater.inflate(R.layout.item_contact_row,parent,false);
      break;
          case TYPE_GRID:
          view= layoutInflater.inflate(R.layout.item_contact_grid,parent,false);
          break;
          default:
              view=null;
      }
        return  new  ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public int gettype() {
        return type;
    }

    public void settype(int type) {
        this.type = type;

    }

    public class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView contactNameTv;
        private TextView contactPhonTv;
        private TextView contactpicpprTv;

        public ContactViewHolder(View itemView){

            super (itemView);
            contactNameTv=itemView.findViewById(R.id.tv_nameContacat);
              contactPhonTv=itemView.findViewById(R.id.tv_numberContacat);
            contactpicpprTv=itemView.findViewById(R.id.tv_picProContacat);

        }
        public void  bindContact(Contact contact){
            contactpicpprTv.setText(contact.getName().substring(0,1));
            contactNameTv.setText(contact.getName());
            contactPhonTv.setText(contact.getPhoneNumber());

        }
    }


}
