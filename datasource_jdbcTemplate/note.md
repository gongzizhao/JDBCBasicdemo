####JDBC控制事务
1. 事务：一个包含多个步骤的业务操作，如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败。  
2. 操作： 
   1. 开启事务  
   2. 提交事务  
   3. 回滚事务
3. 使用Connection对象来管理事务  
   * setAutoCommit(boolean autoCommit):调用该方法设置参数为false即开启事务
   * commit()  
   * rollback()
   
#####数据库连接池
1. 一个存放数据库连接的容器：当系统初始化好后，容器被创建，容器中会申请一些连接对象。  
2. 节约资源；用户访问高效  
3. 实现：
   1. 标准接口：DataSource 
      1. 获取连接：getConnection()
      2. 归还连接：close()
   2. 一般我们不去实现他，有数据库厂商来实现
      1. C3P0:数据库连接池技术
      2. Druid：数据库连接池实现技术，阿里提供
4. C3P0:  
   1. 导入jar包  
   2. 定义配置文件  
      * 名称：c3p0.properties or c3p0-config.xml  
      * 路径：src目录下
   3. 创建核心对象 ComboPooledDataSource
   4. 获取连接：getConnection()  
5. Druid连接步骤
   1. 导入jar包
   2. 定义配置文件：properties形式；任意名称任意目录
   3. 加载配置文件 
   4. 获取数据库连接池对象：DruidDataSourceFactory
   5. 获取连接：getConnection     
6. Druid定义工具类
   1. 定义1个类JDBCUtils
   2. 提供静态代码块加载配置文件，初始化连接池对象
   3. 提供方法
      1. 获取连接方法：通过数据库连接池获取连接
      2. 释放资源
      3. 获取连接池的方法  
7. SpringJDBC Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发  
   1.步骤  
      1. 导入jar包  
      2. 创建jdbcTemplate对象。依赖于数据源DataSource
          JdbcTemplate template=new JdbcTemplate(ds);  
      3. 调用JdbcTemplate的方法来完成CRUD操作  
      
      