### mybatis select 属性含义
``` sql
<select id="selectStuById" parameterType="Integer"
		parameterMap="" resultType="" flushCache="false" timeout="10000"
		fetchSize="256" statementType="PREPARED" resultSetType="FORWARD_ONLY"
		resultMap="cardAndStu1"></select>
```
* id 在命名空间中唯一标识符，可以被用来引用这条配置信息
* parameterType 用于指定这条语句参数类型的完全限定名或别名，可选
* parameterMap 引用通过《parameterMap 标签定义的参数映射，已经废弃
* resultType 从这条语句中返回的期望类型完全限定名火别名，返回结果是集合类型
* resultMap 用于引用《resultmap 标签配置实体属性与数据库字段建立的记过集映射
* flushCache 控制是否刷新缓存。设置true 会导致二级缓存及本地缓存被清空
* timeout 等待数据返回请求结果的描述，超时抛出异常
* fetchSize jdbc中statement 对象的fetchsize属性。sql执行返回的最大行数
* statementType 可选值：STATEMENT PREPARED默认值 CALLABLE 
* resultSetType 参数可选：FORWARD_ONLEY SCROLL_SENSITIVE SCROLL_INSENSITIVE 
* databaseId 设置了databaseIdProvider mybatis会加载所有不带databaseId或匹配当前的databaseId语句
* resultOrdered 仅针对嵌套结果select语句适用，
* resultSets 设置仅对多个结果集的情况适用，列出语句执行后返回的结果集并每隔结果集给一个名称
* lang 设置指定 languageDriver实现，用于解析 select update insert delete标签中的sql语句生成sqlSource对象

### mybatis insert 属性含义
``` sql
<insert id="addUserExt" parameterType="UserExt" flushCache="true" 
	statementType="PREPARED" keyProperty="id" keyColumn="id" 
	useGeneratedKeys="true" timeout="20">
	</insert>
```

* useGeneratedKeys 该属性仅对 update insert 标签有用，true 适用jdbc statement对象的getGeneratedKeys()方法取出有数据库内生成的键值
* keyProperty 该属性仅对 update insert 标签有用，用于数据库自增住建或insert 标签中selectKey标签返回的值填充到实体的属性中，多个用逗号分割
* keyColumn 该属性仅对 update insert 标签有用，生成的键值设置表中的列名，仅在某些数据库中必须


