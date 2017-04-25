# jpa-native-query-demo

### What's this

The example shows how to use JPA 2.1 native query to return unmanaged instances.

### Prerequisite

Java and maven, eclipse or idea is recommended develop tool.

### How to run

1. git clone https://github.com/liudonghua123/jpa-native-query-demo.git
2. cd jpa-native-query-demo
3. configure the datasource settings in src/main/resources/application.properties
4. mvn spring-boot:run

### Try it

After started the web app, you can try out `/add`, `/userPartial/{username}`, `/count` endpoint.

- `/add` is for adding a new sample user.
- `/userPartial/{username}` is for showing the partial user attributes, the {username} is optional.
- `/count` is for showing the count of record.

### Some key code

Define the named native query on one of entity class, put it on the releated entity is better

```
@SqlResultSetMapping(
	    name="userPartialMapping",
	    classes={
	        @ConstructorResult(
	                targetClass = UserPartial.class,
	            columns={
	                @ColumnResult(name="id"),
	                @ColumnResult(name="username")
	            }
	        )
	    }
	)
@NamedNativeQueries({
	@NamedNativeQuery(name="UserRepository.getAllUserPartials", query="select id, username from users", resultSetMapping="userPartialMapping"),
	@NamedNativeQuery(name="UserRepository.getUserParital", query="select id, username from users where username = :username", resultSetMapping="userPartialMapping")
})
@Entity
@Table(name="users")
public class User {
......
}
```

In the repository, link the named native query

```
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(name="UserRepository.getUserParital", nativeQuery=true)
	List<UserPartial> getUserPartialsByUsername(@Param("username") String username);

	@Query(name="UserRepository.getAllUserPartials", nativeQuery=true)
	List<UserPartial> getAllUserPartials();

	@Query(value="select count(*) as count from users", nativeQuery=true)
	List<Object> getUserCount();
}

```
