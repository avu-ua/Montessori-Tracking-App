package ua.co.a_byte_at_a_bite.montessoritracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

data class Presentation(val name: String)

data class Topic(val name: String, val presentations: List<Presentation>)

class ExpandableListAdapter(
    private val context: Context,
    private val topics: List<Topic>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = topics.size

    override fun getChildrenCount(groupPosition: Int): Int = topics[groupPosition].presentations.size

    override fun getGroup(groupPosition: Int): Any = topics[groupPosition]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        topics[groupPosition].presentations[childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val groupView = LayoutInflater.from(context).inflate(R.layout.list_group, parent, false)
        val groupNameTextView: TextView = groupView.findViewById(R.id.groupNameTextView)
        groupNameTextView.text = topics[groupPosition].name

        // Set background color based on group position
        when (groupPosition) {
            0 -> groupView.setBackgroundColor(ContextCompat.getColor(context, R.color.dark_blue))
            1 -> groupView.setBackgroundColor(ContextCompat.getColor(context, R.color.dark_green))
            2 -> groupView.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
            // Add more cases as needed
            else -> groupView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_group_color))
        }

        return groupView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val childView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        val lessonNameTextView: TextView = childView.findViewById(R.id.lessonNameTextView)
        val statusImageView: ImageView = childView.findViewById(R.id.statusImageView)
        lessonNameTextView.text = topics[groupPosition].presentations[childPosition].name

        // Set background color based on group and child positions
        when {
            // Example: Set light blue background for "done" items
            groupPosition == 0 && childPosition in 0..1 -> {
                childView.setBackgroundColor(ContextCompat.getColor(context, R.color.light_blue))
                statusImageView.setImageResource(R.drawable.checked_box)
            }
            // Example: Set light gray background for other items
            groupPosition == 0 -> {
                childView.setBackgroundColor(ContextCompat.getColor(context, R.color.light_gray))
                statusImageView.setImageResource(R.drawable.unchecked_box)
            }
            // Add more cases as needed
            else -> {
                childView.setBackgroundColor(ContextCompat.getColor(context, R.color.default_child_color))
                statusImageView.setImageResource(R.drawable.unchecked_box)
            }
        }

        return childView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true
}
