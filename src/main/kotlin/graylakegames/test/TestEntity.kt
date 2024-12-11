package graylakegames.test

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant

@Entity
data class TestEntity(

    val name: String,

    // Nullable Int causes failure
    val amount: Int? = null,

    // Nullable Instant causes failure
    val published: Instant? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "test_entity_sequence")
    @SequenceGenerator(name = "test_entity_sequence", allocationSize = 1)
    val id: Long = -1
)

interface TestEntityRepository : JpaRepository<TestEntity, Long>
