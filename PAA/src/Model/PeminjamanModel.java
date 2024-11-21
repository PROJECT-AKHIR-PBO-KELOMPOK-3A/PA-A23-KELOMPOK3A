/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ideapadGAMING
 */
public class PeminjamanModel {
    private String id;
    private String idStaf;
    private String nim;
    private String kelas;
    private String prodi;
    private String tanggal;
    private String waktu;
    private String status;

    // Constructor
    public PeminjamanModel(String id, String idStaf, String nim, String kelas, String prodi, String tanggal, String waktu, String status) {
        this.id = id;
        this.idStaf = idStaf;
        this.nim = nim;
        this.kelas = kelas;
        this.prodi = prodi;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.status = status;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStaf() {
        return idStaf;
    }

    public void setIdStaf(String idStaf) {
        this.idStaf = idStaf;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
