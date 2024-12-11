package graylakegames.test

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class RunOnStart(
    private val repository: TestEntityRepository
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun run(vararg args: String?) {

        log.info("Save a few Test Entities")

        (1..3).forEach {
            repository.save(TestEntity("Test Entity $it"))
        }

        log.info("All the test entities: ${repository.findAll()}")

        log.info("Started querydsl kotlin ksp test")
    }

}
