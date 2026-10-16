package org.finos.fluxnova.bpm.test.mockito.service;

import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collection;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SuppressWarnings("unused")
public class RuntimeServiceFluentMock {

  private final RuntimeService runtimeService;

  /**
   * Create fluent mock instance and constructs the runtime service mock.
   */
  public RuntimeServiceFluentMock() {
    this.runtimeService = mock(RuntimeService.class);
  }

  public RuntimeServiceFluentMock(RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }

  public RuntimeServiceFluentMock getVariable(final String variableName, final Object value, final Object... values) {
    when(runtimeService.getVariable(anyString(), eq(variableName))).thenReturn(value, values);
    return this;
  }

  public RuntimeServiceFluentMock getVariables(final Map<String, Object> values) {
    when(runtimeService.getVariables(anyString())).thenReturn(values);
    return this;
  }

  public RuntimeServiceFluentMock getVariables(final Collection<String> variableNames, final Map<String, Object> values) {
    when(runtimeService.getVariables(anyString(), eq(variableNames))).thenReturn(values);
    return this;
  }

  public RuntimeServiceFluentMock getVariableLocal(final String variableName, final Object value, final Object... values) {
    when(runtimeService.getVariableLocal(anyString(), eq(variableName))).thenReturn(value, values);
    return this;
  }

  public RuntimeServiceFluentMock getVariablesLocal(final Map<String, Object> values) {
    when(runtimeService.getVariablesLocal(anyString())).thenReturn(values);
    return this;
  }

  public RuntimeServiceFluentMock getVariablesLocal(final Collection<String> variableNames, final Map<String, Object> values) {
    when(runtimeService.getVariablesLocal(anyString(), eq(variableNames))).thenReturn(values);
    return this;
  }

  public <T extends TypedValue> RuntimeServiceFluentMock getVariableLocalTyped(final String variableName, boolean deserializeValues, final T value, final T... values) {
    thenReturnSequentially(
      when(runtimeService.getVariableLocalTyped(anyString(), eq(variableName), eq(deserializeValues))),
      value,
      values
    );
    return this;
  }

  public RuntimeServiceFluentMock getVariablesLocalTyped(boolean deserializeValues, final VariableMap values) {
    when(runtimeService.getVariablesLocalTyped(anyString(), eq(deserializeValues))).thenReturn(values);
    return this;
  }

  public RuntimeServiceFluentMock getVariablesLocalTyped(final Collection<String> variableNames, boolean deserializeValues, final VariableMap values) {
    when(runtimeService.getVariablesLocalTyped(anyString(), eq(variableNames), eq(deserializeValues))).thenReturn(values);
    return this;
  }

  public <T extends TypedValue> RuntimeServiceFluentMock getVariableLocalTyped(final String variableName, final T value, final T... values) {
    thenReturnSequentially(
      when(runtimeService.getVariableLocalTyped(anyString(), eq(variableName))),
      value,
      values
    );
    return this;
  }

  public RuntimeServiceFluentMock getVariablesLocalTyped(final VariableMap values) {
    when(runtimeService.getVariablesLocalTyped(anyString())).thenReturn(values);
    return this;
  }

  public <T extends TypedValue> RuntimeServiceFluentMock getVariableTyped(final String variableName, boolean deserializeValues, final T value, final T... values) {
    thenReturnSequentially(
      when(runtimeService.getVariableTyped(anyString(), eq(variableName), eq(deserializeValues))),
      value,
      values
    );
    return this;
  }

  public RuntimeServiceFluentMock getVariablesTyped(boolean deserializeValues, final VariableMap values) {
    when(runtimeService.getVariablesTyped(anyString(), eq(deserializeValues))).thenReturn(values);
    return this;
  }

  public RuntimeServiceFluentMock getVariablesTyped(final Collection<String> variableNames, boolean deserializeValues, final VariableMap values) {
    when(runtimeService.getVariablesTyped(anyString(), eq(variableNames), eq(deserializeValues))).thenReturn(values);
    return this;
  }

  public <T extends TypedValue> RuntimeServiceFluentMock getVariableTyped(final String variableName, final T value, final T... values) {
    thenReturnSequentially(
      when(runtimeService.getVariableTyped(anyString(), eq(variableName))),
      value,
      values
    );
    return this;
  }

  public RuntimeServiceFluentMock getVariablesTyped(final VariableMap values) {
    when(runtimeService.getVariablesTyped(anyString())).thenReturn(values);
    return this;
  }

  public RuntimeService getRuntimeService() {
    return runtimeService;
  }

  private static <T> void thenReturnSequentially(final OngoingStubbing<T> stubbing, final T value, final T[] values) {
    OngoingStubbing<T> ongoingStubbing = stubbing.thenReturn(value);
    for (final T nextValue : values) {
      ongoingStubbing = ongoingStubbing.thenReturn(nextValue);
    }
  }
}
