package mg.tonymushah.ejbtest.server.interfaces.remote;

import jakarta.ejb.Remote;

/**
 * PeopleWithMemory
 */
@Remote
public interface PeopleWithMemory extends People, HasMemory {
}