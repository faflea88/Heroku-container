package org.rizki.mufrizal.heroku.container.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import java.net.URI
import javax.sql.DataSource

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 11 February 2018
 * @Time 10:31 PM
 * @Project Heroku-Container
 * @Package org.rizki.mufrizal.heroku.container.configuration
 * @File DataSourceConfiguration
 *
 */

@Configuration
class DataSourceConfiguration @Autowired constructor(val environment: Environment) {

    @Bean(destroyMethod = "close")
    fun dataSource(): DataSource {
        val databaseUrl = URI(environment.getRequiredProperty("spring.datasource.url"))
        val dataSourceConfig = HikariConfig()
        dataSourceConfig.driverClassName = environment.getRequiredProperty("spring.datasource.driver-class-name")
        dataSourceConfig.jdbcUrl = "jdbc:postgresql://${databaseUrl.host}:${databaseUrl.port}${databaseUrl.path}"
        dataSourceConfig.username = databaseUrl.userInfo.split(":")[0]
        dataSourceConfig.password = databaseUrl.userInfo.split(":")[1]
        dataSourceConfig.maximumPoolSize = environment.getRequiredProperty("spring.datasource.maximumPoolSize").toInt()
        dataSourceConfig.minimumIdle = environment.getRequiredProperty("spring.datasource.minimumIdle").toInt()
        dataSourceConfig.connectionTimeout = environment.getRequiredProperty("spring.datasource.connectionTimeout").toLong()
        dataSourceConfig.idleTimeout = environment.getRequiredProperty("spring.datasource.idleTimeout").toLong()
        dataSourceConfig.addDataSourceProperty("poolName", environment.getRequiredProperty("spring.datasource.poolName"))
        dataSourceConfig.addDataSourceProperty("cachePrepStmts", true)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", 250)
        dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", 2048)
        return HikariDataSource(dataSourceConfig)
    }
}