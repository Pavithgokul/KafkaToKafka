package com.spark.structured.streaming

import org.apache.spark.sql.SparkSession
import org.apache.log4j.{ Logger, Level }

object KafkaToKafka extends App{

  private final val logger = Logger.getLogger(KafkaToKafka.getClass)

  logger.setLevel(Level.INFO)

  var spark: SparkSession = null

  try {
  
    logger.info("Creating sparkSession")

    spark = SparkSession.builder().master("local[*]").appName("testing_kafka").getOrCreate()
  
    import spark.implicits._

    logger.info("creating inputstream")

    val inputStream = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "InputTopic")
      .option("startingOffsets", "earliest")
      .option("failOnDataLoss", "false")
      .load()
      .selectExpr("CAST(value AS STRING)")
      .as[String]

 
    val outputStream = inputStream.writeStream
      .format("Kafka")
      .option("checkpointLocation", "hdfs://localhost:54310/")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("topic", "OutputTopic")
      .queryName("MetricsSample")
      .start()
    outputStream.status




     } catch {
         case ex: Exception => logger.error(ex.getMessage)
  }
    spark.streams.awaitAnyTermination()
    spark.stop

}
