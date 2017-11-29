name :="Spark_Structured_Streaming_KAFKA_to_KAFKA"

version := "1.0"

scalaVersion := "2.11.8"

publishMavenStyle := false

libraryDependencies ++= Seq(
  "org.apache.spark"      %%  "spark-core"      			% "2.2.0",
  "org.apache.spark"      %%  "spark-sql"       			% "2.2.0",
  "org.apache.spark"      %%  "spark-streaming" 			% "2.2.0",
  "org.apache.spark"      %%  "spark-streaming-kafka-0-10" 	% "2.2.0",
  "org.apache.spark"      %%  "spark-sql-kafka-0-10" 		% "2.2.0",
  "org.apache.spark"      %%  "spark-hive" 					% "2.2.0",
  "org.apache.spark"      %%  "spark-yarn" 					% "2.2.0",
  "org.apache.hadoop"     %   "hadoop-client" 				% "2.7.2",
  "org.apache.hadoop"     %   "hadoop-yarn-client" 			% "2.7.2"

  )

