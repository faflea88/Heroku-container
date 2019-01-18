package org.rizki.mufrizal.heroku.container.domain

import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 11 February 2018
 * @Time 10:34 PM
 * @Project Heroku-Container
 * @Package org.rizki.mufrizal.heroku.container.domain
 * @File Barang
 *
 */

@Entity
@Table(name = "tb_barang")
data class Barang(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(name = "id_barang", length = 36)
        val idBarang: String? = null,

        @Column(name = "nama_barang", length = 50)
        val namaBarang: String? = null,

        @Column(name = "jumlah_barang")
        val jumlahBarang: Int? = null,

        @Column(name = "harga_barang")
        val hargabarang: BigDecimal? = null
)