package br.com.racc.banking.notification.domain;

import br.com.racc.banking.notification.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class QueueMessage {
	private QueueMessageType type;
	private ClientDTO clientDTO;
}
