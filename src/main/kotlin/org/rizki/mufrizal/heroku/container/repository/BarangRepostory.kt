package org.rizki.mufrizal.heroku.container.repository

import org.rizki.mufrizal.heroku.container.domain.Barang
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.Description
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 11 February 2018
 * @Time 10:38 PM
 * @Project Heroku-Container
 * @Package org.rizki.mufrizal.heroku.container.repository
 * @File BarangRepostory
 *
 */

@RepositoryRestResource(collectionResourceRel = "barang", path = "barang", collectionResourceDescription = Description("API Barang"))
interface BarangRepostory : PagingAndSortingRepository<Barang, String>