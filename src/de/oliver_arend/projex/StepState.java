package de.oliver_arend.projex;

import java.util.Arrays;

public enum StepState {

	NEW,
	STARTED,
	COMPLETED;
	
	public static StepState atLeastOneNew(StepState ...states) {
		if(Arrays.asList(states).stream().anyMatch(state -> state == StepState.NEW)) {
			return StepState.NEW;
		} else {
			return StepState.COMPLETED;
		}
	}
	
}
