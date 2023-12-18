package com.crif.cff.brk.hsbcb.routes.vida.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrResultDto {

	@JsonProperty("provinsi")
	private String provinsi;

	@JsonProperty("kabupaten_kota")
	private String kabupaten_kota;

	@JsonProperty("golongan_darah")
	private String golongan_darah;

	@JsonProperty("agama")
	private String agama;

	@JsonProperty("alamat")
	private String alamat;

	@JsonProperty("berlaku_hingga")
	private String berlaku_hingga;

	@JsonProperty("kewarganegaraan")
	private String kewarganegaraan;

	@JsonProperty("nik")
	private String nik;

	@JsonProperty("nama")
	private String nama;

	@JsonProperty("pekerjaan")
	private String pekerjaan;

	@JsonProperty("tempat_lahir")
	private String tempat_lahir;

	@JsonProperty("kecamatan")
	private String kecamatan;

	@JsonProperty("jenis_kelamin")
	private String jenis_kelamin;

	@JsonProperty("rt_rw")
	private String rt_rw;

	@JsonProperty("tanggal_lahir")
	private String tanggal_lahir;

	@JsonProperty("status_perkawinan")
	private String status_perkawinan;

	@JsonProperty("kelurahan_desa")
	private String kelurahan_desa;

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getKabupaten_kota() {
		return kabupaten_kota;
	}

	public void setKabupaten_kota(String kabupaten_kota) {
		this.kabupaten_kota = kabupaten_kota;
	}

	public String getGolongan_darah() {
		return golongan_darah;
	}

	public void setGolongan_darah(String golongan_darah) {
		this.golongan_darah = golongan_darah;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getBerlaku_hingga() {
		return berlaku_hingga;
	}

	public void setBerlaku_hingga(String berlaku_hingga) {
		this.berlaku_hingga = berlaku_hingga;
	}

	public String getKewarganegaraan() {
		return kewarganegaraan;
	}

	public void setKewarganegaraan(String kewarganegaraan) {
		this.kewarganegaraan = kewarganegaraan;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}

	public String getRt_rw() {
		return rt_rw;
	}

	public void setRt_rw(String rt_rw) {
		this.rt_rw = rt_rw;
	}

	public String getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(String tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public String getStatus_perkawinan() {
		return status_perkawinan;
	}

	public void setStatus_perkawinan(String status_perkawinan) {
		this.status_perkawinan = status_perkawinan;
	}

	public String getKelurahan_desa() {
		return kelurahan_desa;
	}

	public void setKelurahan_desa(String kelurahan_desa) {
		this.kelurahan_desa = kelurahan_desa;
	}

	@Override
	public String toString() {
		return "OcrResultDto [provinsi=" + provinsi + ", kabupaten_kota=" + kabupaten_kota + ", golongan_darah="
				+ golongan_darah + ", agama=" + agama + ", alamat=" + alamat + ", berlaku_hingga=" + berlaku_hingga
				+ ", kewarganegaraan=" + kewarganegaraan + ", nik=" + nik + ", nama=" + nama + ", pekerjaan="
				+ pekerjaan + ", tempat_lahir=" + tempat_lahir + ", kecamatan=" + kecamatan + ", jenis_kelamin="
				+ jenis_kelamin + ", rt_rw=" + rt_rw + ", tanggal_lahir=" + tanggal_lahir + ", status_perkawinan="
				+ status_perkawinan + ", kelurahan_desa=" + kelurahan_desa + "]";
	}

}
