# GreenDaoDemo
使用Java语言开发的GreenDao数据库框架的Demo。

公司的新的项目使用到GreenDao数据库框架，所以就写这个Demo。

### 使用GreenDao的好处
    1.高性能，使用了GreenDao，大多数实体可以以每秒几千个实体的速率进行插入，更新和加载。
    2.易于使用的强大API，涵盖关系和连接；
    3.微小的依赖库，GreenDao的关键依赖库大小不超过100kb；
    4.GreenDao支持加密数据库来保护敏感数据。

### GreenDao实体类注解说明
    1.@Entity：告诉GreenDao该对象是实体，只有被@Entity注释的Bean类才能被dao类操作
    2.@Id:对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值;
    3.@Property：可以自定义字段名，注意外键不能使用该属性;
    4.@NotNull：属性不能为空 @Transient：使用该注释的属性不会被存入数据库的字段中;
    5.@Unique：该属性值必须在数据库中是唯一值;
    6.@Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改;
