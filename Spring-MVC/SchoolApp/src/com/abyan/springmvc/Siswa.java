package com.abyan.springmvc;

public class Siswa {
	private int nisn;
	private String nama;
	private String tempatLahir;
	private int tanggalLahir;
	private String alamat;
	private String asalSekolah;
	
	public Siswa() {
		// TODO Auto-generated constructor stub
	}

	public Siswa(int nisn, String nama, String tempatLahir, int tanggalLahir, String alamat, String asalSekolah) {
		super();
		this.nisn = nisn;
		this.nama = nama;
		this.tempatLahir = tempatLahir;
		this.tanggalLahir = tanggalLahir;
		this.alamat = alamat;
		this.asalSekolah = asalSekolah;
	}
	
	public int getNisn() {
		return nisn;
	}

	public void setNisn(int nisn) {
		this.nisn = nisn;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public int getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(int tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getAsalSekolah() {
		return asalSekolah;
	}

	public void setAsalSekolah(String asalSekolah) {
		this.asalSekolah = asalSekolah;
	}
}