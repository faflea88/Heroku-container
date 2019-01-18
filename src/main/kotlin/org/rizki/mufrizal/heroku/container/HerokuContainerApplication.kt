package org.rizki.mufrizal.heroku.container

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.hateoas.config.EnableHypermediaSupport

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 11 February 2018
 * @Time 10:31 PM
 * @Project Heroku-Container
 * @Package org.rizki.mufrizal.heroku.container
 * @File HerokuContainerApplication
 *
 */

@SpringBootApplication
@EnableHypermediaSupport(type = [EnableHypermediaSupport.HypermediaType.HAL])
class HerokuContainerApplication

fun main(args: Array<String>) {
    SpringApplication.run(HerokuContainerApplication::class.java, *args)
}