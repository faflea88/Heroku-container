package org.rizki.mufrizal.heroku.container

import com.fasterxml.jackson.databind.ObjectMapper
import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.rizki.mufrizal.heroku.container.domain.Barang
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [HerokuContainerApplication::class])
@AutoConfigureMockMvc
@TestPropertySource(locations = ["classpath:application.properties"])
class HerokuContainerApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun getBarangsTest() {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/barang").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.barang", Matchers.hasSize<Int>(0)))
    }

    @Test
    @Throws(Exception::class)
    fun saveBarangTest() {
        val barang = Barang(namaBarang = "rinso", hargabarang = BigDecimal.valueOf(5000), jumlahBarang = 100)
        mockMvc
                .perform(MockMvcRequestBuilders.post("/api/barang").contentType(MediaType.APPLICATION_JSON).content(ObjectMapper().writeValueAsString(barang)).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated)
    }

}