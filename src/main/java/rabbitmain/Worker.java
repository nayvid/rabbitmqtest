package rabbitmain;

import com.rabbitmq.client.DeliverCallback;

public class Worker extends Send {

	public static void main(String[] args) {
		
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			  String message = new String(delivery.getBody(), "UTF-8");

			  System.out.println(" [x] Received '" + message + "'");
			  try {
			    doWork(message);
			  } finally {
			    System.out.println(" [x] Done");
			  }
			};
			boolean autoAck = true; // acknowledgment is covered below
			channel.basicConsume(TASK_QUEUE_NAME, autoAck, deliverCallback, consumerTag -> { });
		// TODO Auto-generated method stub

	}

}
