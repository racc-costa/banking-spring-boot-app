package br.com.racc.banking.mail.domain;

import br.com.racc.banking.mail.dto.ClientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QueueMessage {
	private QueueMessageType type;
	private ClientDTO clientDTO;
}
