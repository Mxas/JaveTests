package com.exadel.guestregistrations.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exadel.guestregistrations.model.Agent;
import com.exadel.guestregistrations.model.Card;
import com.exadel.guestregistrations.model.Guest;
import com.exadel.guestregistrations.model.GuestAgent;
import com.exadel.guestregistrations.repository.AgentRepository;
import com.exadel.guestregistrations.repository.CardRepository;
import com.exadel.guestregistrations.repository.GuestRepository;

@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private AgentRepository agentRepository;

	@Override
	public List<Guest> findAllGuests() {
		return guestRepository.findAll();
	}

	@Override
	public Guest findById(String id) {
		return guestRepository.findById(id).get();
	}
	
	@Override
	public Guest findByEmail(String email) {
		return guestRepository.findByEmail(email);
	}

	@Override
	public void deleteGuest(String id) {

		Guest thisGuest = guestRepository.findById(id).get();
		int cardNumber = thisGuest.getCardNumber();

		List<Card> cards = cardRepository.findByCardNumber(cardNumber);
		Card card = cards.get(0);
		card.setHolderName("");
		card.setHolderSurname("");

		cardRepository.save(card);
		guestRepository.deleteById(id);
	}

	@Override
	public void addGuest(GuestAgent guestAgent) {
		Agent agent=agentRepository.findByEmail(guestAgent.getEmail()).get(0);
		String agentId=agent.getId();
		Guest guest = new Guest(guestAgent.getOfficeId(), agentId,
				guestAgent.getGuestType(), guestAgent.getArrivalDate(), guestAgent.getLeavingDate(),
				guestAgent.getArrivalPurpose(), guestAgent.getPhoto(), guestAgent.getSignature(),
				guestAgent.getCardNumber());
		

		if (guest.getCardNumber() == 0) {
			List<Card> cards = cardRepository.findByholderName("");
			Random rand = new Random();

			int randomIndex = rand.nextInt(cards.size());
			Card card = cards.get(randomIndex);

			guest.setCardNumber(card.getCardNumber());
			card.setHolderName(agent.getName());
			card.setHolderSurname(agent.getSurname());
			// card.setValidFrom(guest.getArrivalDate());
			// card.setValidTo(guest.getLeavingDate());
			cardRepository.save(card);
		}

		else {
			List<Card> cards = cardRepository.findByCardNumber(guest.getCardNumber());
			Card card = cards.get(0);
			card.setHolderName(agent.getName());
			card.setHolderSurname(agent.getSurname());
			cardRepository.save(card);
		}
		
		guestRepository.save(guest);
	}

	@Override
	public void update(GuestAgent guestAgent) {
		List<Card> cards = cardRepository.findByCardNumber(guestAgent.getCardNumber());
		Card card = cards.get(0);

		Guest thisGuest = guestRepository.findById(guestAgent.getId()).get();
		Agent thisAgent = agentRepository.findById(thisGuest.getAgentId()).get();
		int previousCardNumber = thisGuest.getCardNumber();
		String previousName = thisAgent.getName();
		String previousSurname = thisAgent.getSurname();

		List<Card> cards2 = cardRepository.findByCardNumber(previousCardNumber);
		Card card2 = cards2.get(0);

		if (previousCardNumber != (guestAgent.getCardNumber())) {
			card.setHolderName(guestAgent.getName());
			card.setHolderSurname(guestAgent.getSurname());
			cardRepository.save(card);
			card2.setHolderName("");
			card2.setHolderSurname("");
			cardRepository.save(card2);
		}
		
		if (!previousName.equals(guestAgent.getName())) {
			card.setHolderName(guestAgent.getName());			
			cardRepository.save(card);
		}
		
		if (!previousSurname.equals(guestAgent.getSurname())) {
			card.setHolderSurname(guestAgent.getSurname());			
			cardRepository.save(card);
		}
		
		Guest updatedGuest = new Guest(guestAgent.getOfficeId(), guestAgent.getAgentId(), guestAgent.getGuestType(), guestAgent.getArrivalDate(), guestAgent.getLeavingDate(), guestAgent.getArrivalPurpose(), guestAgent.getPhoto(), guestAgent.getSignature(), guestAgent.getCardNumber());
		updatedGuest.setId(guestAgent.getId());
		
		Agent updatedAgent = new Agent(guestAgent.getName(), guestAgent.getSurname(), guestAgent.getEmail(), guestAgent.getPhoneNo(), guestAgent.getPhoto());
		updatedAgent.setId(guestAgent.getAgentId());
		
		guestRepository.save(updatedGuest);
		agentRepository.save(updatedAgent);
	}

}