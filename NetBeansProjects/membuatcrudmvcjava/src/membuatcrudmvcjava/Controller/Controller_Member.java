/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membuatcrudmvcjava.Controller;

import javax.swing.JOptionPane;
import membuatcrudemvcjava.DAO.DAO_Member;
import membuatcrudmvcjava.DAOImplement.Implement_Member;
import membuatcrudmvcjava.Model.Model_Member;
import membuatcrudmvcjava.Model.Tabel_Model_Member;
import membuatcrudmvcjava.View.View_Member;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Controller_Member {
    
    View_Member frame_member;
    Implement_Member implement_member;
    List<Model_Member> list_member;
    
    public Controller_Member(View_Member frame_member){
        this.frame_member = frame_member;
        implement_member = new DAO_Member();
        list_member = implement_member.getALL();
    }
    
    //Tombol Reset
    public void reset(){
        frame_member.getTxtidkode().setText("");
        frame_member.getTxtnamapelanggan().setText("");
        frame_member.getTxtnotelp().setText("");
        frame_member.getTxtalamat().setText("");
        frame_member.getTxtpaketpelanggan().setSelectedItem("--- Pilih Paket ---");
        frame_member.getTxtCariData().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_member = implement_member.getALL();
        Tabel_Model_Member tmb = new Tabel_Model_Member(list_member);
        frame_member.getTabeldatamember().setModel(tmb);
    }
    
    //Menampilkan Data Ke Form Ketika Data Di Klik
    public void isiField(int row){
        frame_member.getTxtidkode().setText(list_member.get(row).getId().toString());
        frame_member.getTxtnamapelanggan().setText(list_member.get(row).getNama());
        frame_member.getTxtnotelp().setText(list_member.get(row).getNo_telp());
        frame_member.getTxtalamat().setText(list_member.get(row).getAlamat());
        frame_member.getTxtpaketpelanggan().setSelectedItem(list_member.get(row).getPaket());
    }
    
    //Insert Data Dari Form Ke Database
    public void insert(){
        if(!frame_member.getTxtnotelp().getText().trim().isEmpty()& !frame_member.getTxtnamapelanggan().getText().trim().isEmpty()& !frame_member.getTxtalamat().getText().trim().isEmpty()){
            Model_Member b = new Model_Member();
            b.setNama(frame_member.getTxtnamapelanggan().getText());
            b.setNo_telp(frame_member.getTxtnotelp().getText());
            b.setAlamat(frame_member.getTxtalamat().getText());
            b.setPaket(frame_member.getTxtpaketpelanggan().getSelectedItem().toString());
            
            implement_member.insert(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_member.getTxtidkode().getText().trim().isEmpty()){
            Model_Member b = new Model_Member();
            b.setNama(frame_member.getTxtnamapelanggan().getText());
            b.setNo_telp(frame_member.getTxtnotelp().getText());
            b.setAlamat(frame_member.getTxtalamat().getText());
            b.setPaket(frame_member.getTxtpaketpelanggan().getSelectedItem().toString());
            b.setId(Integer.parseInt(frame_member.getTxtidkode().getText()));
            
            implement_member.update(b);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_member.getTxtidkode().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame_member.getTxtidkode().getText());
            
            implement_member.delete(id);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
    //Cari Data
    public void isiTableCariNama(){
        list_member = implement_member.getCariNama(frame_member.getTxtCariData().getText());
        Tabel_Model_Member tmb = new Tabel_Model_Member(list_member);
        frame_member.getTabeldatamember().setModel(tmb);
    }
    
    public void carinama(){
        if(!frame_member.getTxtCariData().getText().trim().isEmpty()){
            implement_member.getCariNama(frame_member.getTxtCariData().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_member, "Silahkan Pilih Data !!!");
        }
    }
}
