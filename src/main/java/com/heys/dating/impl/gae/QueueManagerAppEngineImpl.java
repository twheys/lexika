package com.heys.dating.impl.gae;

import static com.google.appengine.api.taskqueue.TaskOptions.Builder.withUrl;

import org.springframework.stereotype.Service;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.googlecode.objectify.Key;
import com.heys.dating.member.Member;
import com.heys.dating.message.Message;
import com.heys.dating.message.Thread;
import com.heys.dating.service.QueueManager;

@Service("QueueManager")
public class QueueManagerAppEngineImpl implements QueueManager {

	public static final String DELIVER_MSG_URL = "/job/deliver_message";

	private final Queue queue = QueueFactory.getDefaultQueue();

	@Override
	public void deliverMessage(final Key<Member> recipientKey,
			final Key<Thread> threadKey, final Key<Message> messageKey) {
		queue.add(withUrl(DELIVER_MSG_URL)
				.param("recipient", recipientKey.toString())
				.param("thread", threadKey.getString())
				.param("message", messageKey.getString()));

	}
}
