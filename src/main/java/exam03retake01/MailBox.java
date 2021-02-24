package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> findByCriteria(String criteria) {

        Predicate<Mail> predicateEmail =  x -> x.getFrom().getEmail().equals(criteria.substring(criteria.indexOf(':')+1));

        Predicate<Mail> predicateName =  x -> x.getFrom().getName().equals(criteria.substring(criteria.indexOf(':')+1));
        if (criteria.startsWith("from")) {
            return mails.stream().
                    filter(predicateEmail.or(predicateName))
            .collect(Collectors.toList());
        }
        if (criteria.startsWith("to")) {
            List<Mail> result = new ArrayList<>();
            for (Mail mail: mails) {
                for (Contact contact : mail.getTo()) {
                    if (contact.getName().equals(criteria.substring(criteria.indexOf(':')+1)) || contact.getEmail().equals(criteria.substring(criteria.indexOf(':')+1))) {
                        result.add(mail);
                    }
                }
            }
            return result;
        }
        else {
            List<Mail> result = new ArrayList<>();
            for (Mail mail: mails) {
                if (mail.getSubject().contains(criteria) || mail.getMessage().contains(criteria)) {
                    result.add(mail);
                }
            }
            return result;
        }

    }
}
