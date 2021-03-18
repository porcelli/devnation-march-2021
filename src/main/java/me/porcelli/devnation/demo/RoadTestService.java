package me.porcelli.devnation.demo;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RoadTestService {

    private final Map<String, Applicant> applicants = new HashMap<>();
    private final Map<String, RoadTestStatus> status = new HashMap<>();

    public RoadTestStatus requestRoadTest(Applicant applicant) {
        return status.computeIfAbsent(applicant.getId(), k -> {
            applicants.put(applicant.getId(), applicant);
            return RoadTestStatus.WAITING;
        });
    }

    public void schedule(String id) {
        transition(id, RoadTestStatus.WAITING, RoadTestStatus.SCHEDULED);
    }

    public void failTest(String id) {
        transition(id, RoadTestStatus.SCHEDULED, RoadTestStatus.FAIL);
    }

    public Applicant passTest(String id) {
        transition(id, RoadTestStatus.SCHEDULED, RoadTestStatus.PASS);
        return applicants.get(id);
    }

    public RoadTestStatus status(String id) {
        final RoadTestStatus result = status.getOrDefault(id, RoadTestStatus.ERROR);
        if (result.equals(RoadTestStatus.ERROR)) {
            throw new RoadTestInvalidStateException("Invalid state!");
        }
        return result;
    }

    private void transition(String id, RoadTestStatus from, RoadTestStatus to) {
        if (status(id).equals(from)) {
            status.put(id, to);
            return;
        }
        throw new RoadTestInvalidStateException("Invalid state!");
    }
}
