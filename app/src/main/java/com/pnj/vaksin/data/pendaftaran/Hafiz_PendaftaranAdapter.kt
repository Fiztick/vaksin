package com.pnj.vaksin.data.pendaftaran

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.pnj.vaksin.R
import java.io.File

class Hafiz_PendaftaranAdapter(private val pendaftaranList: ArrayList<Hafiz_Pendaftaran>) :
    RecyclerView.Adapter<Hafiz_PendaftaranAdapter.PendaftarViewHolder>(){
    class PendaftarViewHolder(pendaftaranItemView: View) : RecyclerView.ViewHolder(pendaftaranItemView) {
        val nama_pendaftar : TextView = pendaftaranItemView.findViewById(R.id.TVLNamaPendaftar)
        val jenis_kelamin_pendaftar : TextView = pendaftaranItemView.findViewById(R.id.TVLJenisKelaminPendaftar)
        val umur_pendaftar : TextView = pendaftaranItemView.findViewById(R.id.TVLUmurPendaftar)

        val img_pendaftar : ImageView = pendaftaranItemView.findViewById(R.id.IMLFotoPendaftar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendaftarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pendaftaran_list_layout, parent, false)
        return PendaftarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PendaftarViewHolder, position: Int) {
        val currentItem = pendaftaranList[position]
        val foto_dir = currentItem.foto_pendaftar.toString()
        val imgFile = File("${Environment.getExternalStorageDirectory()}/${foto_dir}")
        val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)

        holder.img_pendaftar.setImageBitmap(myBitmap)
        holder.nama_pendaftar.text = currentItem.nama_pendaftar.toString()

        holder.umur_pendaftar.text = currentItem.umur_pendaftar.toString()

        if (currentItem.jenis_kelamin_pendaftar.toString() == "2131230733") {
            holder.jenis_kelamin_pendaftar.text = "Laki - laki"
        } else {
            holder.jenis_kelamin_pendaftar.text = "Perempuan"
        }

        holder.itemView.setOnClickListener {
            val activity = it.context as AppCompatActivity
            activity.startActivity(Intent(activity, Hafiz_EditPendaftaranActivity::class.java).apply {
                putExtra("nama_pendaftar", currentItem.nama_pendaftar.toString())
                putExtra("jenis_kelamin_pendaftar", currentItem.jenis_kelamin_pendaftar.toString())
                putExtra("umur_pendaftar", currentItem.umur_pendaftar.toString())
                putExtra("foto_pendaftar", currentItem.foto_pendaftar.toString())
                putExtra("nik_pendaftar", currentItem.nik_pendaftar.toString())
                putExtra("penyakit_bawaan_pendaftar", currentItem.penyakit_bawaan_pendaftar.toString())
                putExtra("id", currentItem.id.toString())
            })
        }
    }

    override fun getItemCount(): Int {
        return pendaftaranList.size
    }
}