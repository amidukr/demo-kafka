package org.amidukr.demokafka.consumer

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
		properties = ["env=dev"]
)
class ApplicationTests {

	@Test
	fun contextLoads() {
	}

}
