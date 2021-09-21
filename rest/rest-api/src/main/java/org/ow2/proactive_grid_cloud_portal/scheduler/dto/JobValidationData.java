/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package org.ow2.proactive_grid_cloud_portal.scheduler.dto;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class JobValidationData {
    private boolean valid;

    private String taskName;

    private String errorMessage;

    private String stackTrace;

    private Map<String, String> updatedVariables;

    private Map<String, String> updatedModels;

    private Map<String, String> updatedDescriptions;

    private Map<String, String> updatedGroups;

    private Map<String, Boolean> updatedAdvanced;

    private Map<String, Boolean> updatedHidden;

    public JobValidationData() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Map<String, String> getUpdatedVariables() {
        return updatedVariables;
    }

    public void setUpdatedVariables(Map<String, String> updatedVariables) {
        this.updatedVariables = updatedVariables;
    }

    public void setUpdatedModels(Map<String, String> updatedModels) {
        this.updatedModels = updatedModels;
    }

    public Map<String, String> getUpdatedModels() {
        return updatedModels;
    }

    public Map<String, String> getUpdatedDescriptions() {
        return updatedDescriptions;
    }

    public void setUpdatedDescriptions(Map<String, String> updatedDescriptions) {
        this.updatedDescriptions = updatedDescriptions;
    }

    public Map<String, String> getUpdatedGroups() {
        return updatedGroups;
    }

    public void setUpdatedGroups(Map<String, String> updatedGroups) {
        this.updatedGroups = updatedGroups;
    }

    public Map<String, Boolean> getUpdatedAdvanced() {
        return updatedAdvanced;
    }

    public void setUpdatedAdvanced(Map<String, Boolean> updatedAdvanced) {
        this.updatedAdvanced = updatedAdvanced;
    }

    public Map<String, Boolean> getUpdatedHidden() {
        return updatedHidden;
    }

    public void setUpdatedHidden(Map<String, Boolean> updatedHidden) {
        this.updatedHidden = updatedHidden;
    }
}
