import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import io.getquill.{LowerCase, PostgresJdbcContext}

package object DbSetup {
  def getDbContext(dbName: String, port: Int): PostgresJdbcContext[LowerCase.type] = {
    val pgDataSource = new org.postgresql.ds.PGSimpleDataSource()
    pgDataSource.setUser("postgres")
    pgDataSource.setPassword("postgres")
    pgDataSource.setDatabaseName(dbName)
    pgDataSource.setPortNumbers(Array(port))
    val config = new HikariConfig()
    config.setDataSource(pgDataSource)
    new PostgresJdbcContext(LowerCase, new HikariDataSource(config))
  }
}

