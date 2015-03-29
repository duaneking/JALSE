package jalse.misc;

import jalse.JALSE;
import jalse.actions.ActionEngine;
import jalse.attributes.AttributeSet;
import jalse.attributes.AttributeType;
import jalse.attributes.Attributes;
import jalse.entities.Entity;
import jalse.entities.EntityContainer;
import jalse.entities.EntityProxies;

import java.util.function.Supplier;

/**
 * These are the suppliers for all the common specific exceptions JALSE throws. JALSE currently does
 * not provide any custom exception types but instead uses the suitable {@code java.lang}
 * exceptions.
 *
 * @author Elliot Ford
 *
 */
public final class JALSEExceptions {

    /**
     * Runtime exception supplier for when an entity is associated twice.
     *
     * @see EntityContainer
     */
    public static final Supplier<RuntimeException> ENTITY_ALREADY_ASSOCIATED = () -> new IllegalArgumentException(
	    "Entity is already associated");

    /**
     * Runtime exception supplier for attempting to change the running state of a stopped engine.
     *
     * @see ActionEngine
     */
    public static final Supplier<RuntimeException> ENGINE_SHUTDOWN = () -> new IllegalStateException(
	    "Engine has already been stopped");

    /**
     * Runtime exception supplier for when a entity is created past the total entity limit set.
     *
     * @see JALSE
     */
    public static final Supplier<RuntimeException> ENTITY_LIMIT_REACHED = () -> new IllegalStateException(
	    "Entity limit has been reached");

    /**
     * Runtime exception supplier for when an {@code interface} without {@link Entity} as a parent
     * is being used as an entity type.
     *
     * @see EntityProxies
     */
    public static final Supplier<RuntimeException> INVALID_ENTITY_TYPE = () -> new IllegalArgumentException(
	    "Entity type is invalid");

    /**
     * Runtime exception supplier for creation operations are done against an entity that is no
     * longer alive.
     *
     * @see Entity
     */
    public static final Supplier<RuntimeException> ENTITY_NOT_ALIVE = () -> new IllegalStateException(
	    "Entity is no longer alive");

    /**
     * An Entity has been exported from one container but was not able to be transfered to the
     * destination container.
     *
     * @see EntityContainer
     */
    public static final Supplier<RuntimeException> ENTITY_EXPORT_NO_TRANSFER = () -> new IllegalStateException(
	    "Entity exported but not transfered");

    /**
     * Attribute types should be the wrapped types not primitives (as they are not equal).
     *
     * @see Attributes
     */
    public static final Supplier<RuntimeException> PRIMITIVE_VALUE_TYPE = () -> new IllegalArgumentException(
	    "Attribute value types cannot be primitives (may be null)");

    /**
     * The attribute value does not match the attribute type.
     *
     * @see AttributeSet
     * @see AttributeType
     */
    public static final Supplier<RuntimeException> TYPE_VALUE_MISMATCH = () -> new IllegalArgumentException(
	    "Attribute value type does not match value type");

    /**
     * Throws the runtime exception generated by the supplier.
     *
     * @param supplier
     *            Runtime exception supplier.
     * @throws RuntimeException
     *             Will throw the supplied exception or will null pointer if supplied with
     *             {@code null}.
     */
    public static void throwRE(final Supplier<? extends RuntimeException> supplier) throws RuntimeException {
	throw supplier.get();
    }

    private JALSEExceptions() {
	throw new UnsupportedOperationException();
    }
}
